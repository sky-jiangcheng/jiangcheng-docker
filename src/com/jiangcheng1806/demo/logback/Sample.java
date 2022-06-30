package com.jiangcheng1806.demo.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;


public class Sample {
	private static final Logger LOGGER = LoggerFactory.getLogger(Sample.class);
public static void main(String[] args) {
	LOGGER.info(">>>>>start a loback test");
	/*
	 * Logback ��ʼ��ʱ����������˳�������ã�
	 * 
	 * ��·���³���Ѱ�� logback-test.xml ��û�У���·���³���Ѱ�� logback.groovy ��û�У���·���³���Ѱ��
	 * logback.xml ��û�У����Ի��� Java SPI ����Ѱ�� com.qos.logback.classic.spi.Configurator
	 * �ӿڵ�ʵ�� �����϶�û�У�Logback ��ʹ��������� BasicConfigurator �����Լ��� �⽫ʹ�� TTLLLayout������
	 * PatternLayout��
	 * ��"%d{HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n"ģʽ��ʽ����־������
	 * ConsoleAppender ���ӵ� root Logger��������������̨���� root ��ָ��Ϊ DEBUG �ȼ���
	 */
	StatusPrinter.print((LoggerContext) LoggerFactory.getILoggerFactory());
}
}
