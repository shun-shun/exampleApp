package jp.ac.hcs.gondo.app.common;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
public class WebConfig {

	/**
	 * MessageSourceライブラリのインスタンスを生成します。
	 *
	 * <p>こちらはDIのために利用されることを想定しています。
	 * <p><strong><code>controller</code>や<code>service</code>から呼び出さないでください。</strong><br>
	 * 設定することで、<code>@Autowired</code>が設定されたプロパティへ自動的にインスタンスが設定されます。
	 *
	 * @return MessageSourceインスタンス
	 */
	@Bean
	public MessageSource messageSource() {

		//メッセージプロパティのファイル設定
		ReloadableResourceBundleMessageSource bean = new ReloadableResourceBundleMessageSource();
		bean.setBasename("classpath:messages");
		bean.setDefaultEncoding("UTF-8");

		return bean;
	}
	
	/**
	 * LocalValidatorFactoryBeanライブラリのインスタンスを生成します。
	 *
	 * <p>こちらはDIのために利用されることを想定しています。
	 * <p><strong><code>controller</code>や<code>service</code>から呼び出さないでください。</strong><br>
	 * 設定することで、<code>@Autowired</code>が設定されたプロパティへ自動的にインスタンスが設定されます。
	 *
	 * @return LocalValidatorFactoryBeanインスタンス
	 */
	@Bean
	public LocalValidatorFactoryBean localValidatorFactoryBean() {

		// バリデーションのメッセージ設定
		LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
		localValidatorFactoryBean.setValidationMessageSource(messageSource());

		return localValidatorFactoryBean;
	}
}
