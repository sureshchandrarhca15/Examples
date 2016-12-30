package com.test;

import javax.naming.NamingException;

import org.springframework.jndi.JndiObjectFactoryBean;

public class JndiFactoryFactory {

	private ClassLoader prevClassLoader;

	public JndiObjectFactoryBean createJndiObjectFactory() throws IllegalArgumentException, NamingException {
		this.setPrevClassLoader(Thread.currentThread().getContextClassLoader());
		Thread.currentThread().setContextClassLoader(this.getClass().getClassLoader());

		JndiObjectFactoryBean bean = new JndiObjectFactoryBean();
		return bean;
	}

	public void destroyJndiObjectFactory() throws IllegalArgumentException, NamingException {
		Thread.currentThread().setContextClassLoader(getPrevClassLoader());
	}

	public ClassLoader getPrevClassLoader() {
		return prevClassLoader;
	}

	public void setPrevClassLoader(ClassLoader prevClassLoader) {
		this.prevClassLoader = prevClassLoader;
	}

}