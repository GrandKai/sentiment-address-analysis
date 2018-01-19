package com.linlong;

import com.hankcs.hanlp.HanLP;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

//@Import(value = {WebConfig.class})
@RestController
@SpringBootApplication
//@EnableAutoConfiguration
//@ImportResource(locations={"classpath:spring-consumer.xml","classpath:spring-rabbitmq-producer.xml","classpath:spring-component.xml"})
//@EnableAspectJAutoProxy
//@EnableCaching
//@ComponentScan(value = {"com.linlong.sentiment","com.linlong.sentiment.controller"})
@ComponentScan(basePackageClasses = App.class)
public class App {

	@RequestMapping("/")
	public Map home() {
		Map<String,String> result = new HashMap<String,String>();
		result.put("welcomeMessage","Welcome linlong sentiment-analysis site.");

		return result;
	}

	public static void main(String[] args) {
		System.out.println("首次编译运行时，HanLP会自动构建词典缓存，请稍候……");
		HanLP.Config.enableDebug(true);
		//CustomDictionary.reload();
		SpringApplication.run(App.class);
	}
}
