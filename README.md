# concurrent-project
并发学习

线程安全-原子性的实现：
atomic类、synchronized、Lock
比较：
synchronized:不可中断锁，适合竞争不激烈，可读性好
Lock:可中断锁，多样化同步，竞争激烈时能维持常态
Atomic:竞争激烈时能维持常态，比Lock性能好；只能同步一个值
