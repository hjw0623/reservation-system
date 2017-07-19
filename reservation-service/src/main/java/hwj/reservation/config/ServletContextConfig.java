package hwj.reservation.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages ={"hwj.reservation.controller"})
public class ServletContextConfig extends WebMvcConfigurerAdapter{
	//외부 디렉토리 이미지 경로 
	@Value	("${static.product.image.location}") 
	private String staticResouceLocation;

	@Bean
	public ViewResolver viewResolver(){
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	//리소스에 대한 설정 추가
	@Override 
	public void addResourceHandlers(ResourceHandlerRegistry registry){
		//   webapp/resources 경로를 의미
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/"); 	
		registry.addResourceHandler("/imgresources/**").addResourceLocations(staticResouceLocation); 
	}
	
	@Bean
	public MultipartResolver multipartResolver() {
        org.springframework.web.multipart.commons.CommonsMultipartResolver multipartResolver 
        					= new org.springframework.web.multipart.commons.CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(10485760); // 1024 * 1024 * 10
        return multipartResolver;
    }	
}
