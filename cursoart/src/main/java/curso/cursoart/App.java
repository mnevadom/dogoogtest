package curso.cursoart;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import curso.cursoart.beans.HolaConfig;
import curso.cursoart.beans.Mundo;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
    	ApplicationContext context = new AnnotationConfigApplicationContext(HolaConfig.class);
    	
    	Mundo m1 = (Mundo)context.getBean("mundo1");
    	
    	System.out.println(m1.getSaludo());
    }
}
