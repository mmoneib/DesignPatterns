package com.moneib.designpatterns.multithreading.producerconsumer;

import java.util.Queue;

public abstract class Consumer<T> extends Thread {
	private Queue<T> buffer;

	public Consumer(Queue<T> buffer) {
		this.buffer = buffer;
	}

	@Override
	public void run() {
		while (true) {
			T product = null;

			synchronized (buffer) {
				if (!buffer.isEmpty()) {
					product = buffer.poll();
					buffer.notifyAll();
				} else {
					try {
						buffer.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}

			if (product != null) {
				consume(product);
			}
		}
	}

	protected abstract void consume(T product);
}
