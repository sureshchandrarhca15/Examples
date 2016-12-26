package com.test;

import javax.naming.NamingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jndi.JndiObjectFactoryBean;

public class JndiFactoryFactory {

	public static Logger LOG = LoggerFactory.getLogger(JndiFactoryFactory.class);
	private ClassLoader prevClassLoader;

	public JndiObjectFactoryBean createJndiObjectFactory() throws IllegalArgumentException, NamingException {
		LOG.info("createJndiObjectFactory() called.");
		this.setPrevClassLoader(Thread.currentThread().getContextClassLoader());
		LOG.info("TCCL currently set to {}.", getPrevClassLoader());
		Thread.currentThread().setContextClassLoader(this.getClass().getClassLoader());
		LOG.info("Setting TCCL to be the Bundle class loader {}.", Thread.currentThread().getContextClassLoader());
		LOG.info("I got called from Thread {}", Thread.currentThread().getName());

		JndiObjectFactoryBean bean = new JndiObjectFactoryBean();
		return bean;
	}

	public void destroyJndiObjectFactory() throws IllegalArgumentException, NamingException {
		LOG.info("destroyJndiObjectFactory() called.");
		LOG.info("TCCL currently set to {}.", Thread.currentThread().getContextClassLoader());
		Thread.currentThread().setContextClassLoader(getPrevClassLoader());
		LOG.info("Setting TCCL to be the Bundle class loader {}.", Thread.currentThread().getContextClassLoader());
		LOG.info("I got called from Thread {}", Thread.currentThread().getName());
	}

	public ClassLoader getPrevClassLoader() {
		return prevClassLoader;
	}

	public void setPrevClassLoader(ClassLoader prevClassLoader) {
		this.prevClassLoader = prevClassLoader;
	}

}