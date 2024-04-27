# Simple Deadlock Demonstration in Java

This repository contains a simple Java program that demonstrates a deadlock scenario using synchronized blocks and threads.

## Definition

Deadlock is a condition where two or more threads are blocked forever, waiting for each other to release the desired resources. This Java program intentionally creates a deadlock situation to illustrate the concept and help understand the conditions that can lead to such a state in a multithreaded environment.

## How the Deadlock Occurs

- `Thread 1` acquires `lock1` and then tries to acquire `lock2` after a sleep period of `100ms`.
- Simultaneously, `Thread 2` acquires `lock2` and then attempts to acquire `lock1` after its own `100ms` sleep period.
- Since each thread holds one lock and is waiting for the other, neither can proceed, and a deadlock occurs.
