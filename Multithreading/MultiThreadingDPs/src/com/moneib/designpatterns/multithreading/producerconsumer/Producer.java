package com.moneib.designpatterns.multithreading.producerconsumer;

import java.util.Queue;

public abstract class Producer<T> extends Thread {
	private Queue<T> buffer;
	private int maxSize;

	public Producer(Queue<T> buffer, int maxSize) {
		this.buffer = buffer;
		this.maxSize = maxSize;
	}

	@Override
	public void run() {
		while (true) {
			T product = produce();

			synchronized (buffer) {
				if (buffer.size() < maxSize) {
					try {
						sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					buffer.add(product);
					buffer.notifyAll();
				} else {
					try {
						buffer.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	protected abstract T produce();
}
