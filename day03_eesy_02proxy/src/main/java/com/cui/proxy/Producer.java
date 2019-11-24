package com.cui.proxy;

/**
 * 一个生产者
 */
public class Producer implements IProducer {

    public void saleProduct(float money) {
        System.out.println("销售产品，拿到钱：" + money);
    }

    public void afterService(float money) {
        System.out.println("提供售后服务，拿到钱：" + money);
    }
}















