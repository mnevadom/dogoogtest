package com.udemy.backend.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.udemy.backend.entity.User;
import com.udemy.backend.entity.UserRole;
import com.udemy.backend.respositories.UserRepository;

@Service("userService")
public class UserServiceImpl implements UserDetailsService{
	
	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		List<GrantedAuthority> authorities = buildAuthorities(user.getUserRoles());
		
		return buildUser(user, authorities);
	}

	// spring secutity trabaja con estos objetos. Authorities seran en realidad mis roles de la entity
	private org.springframework.security.core.userdetails.User buildUser(User user, List<GrantedAuthority> authorities){
		
		// lo suyo es meter en una tabla si la cuenta está expirada, bloqueada etc. Lo vamos a dejar a true todo
		
		return new org.springframework.security.core.userdetails.User(user.getUsername(), 
				user.getPassword(), 
				user.isEnabled(), 
				true, true, true, 
				buildAuthorities(user.getUserRoles()));
	}
	
	private List<GrantedAuthority> buildAuthorities(Set<UserRole> roles){
		Set<GrantedAuthority> auths = new HashSet<GrantedAuthority>();
		
		roles.stream().forEach(role -> auths.add(new SimpleGrantedAuthority(role.getRole())));
		
		return auths.stream().collect(Collectors.toList());
	}
}
