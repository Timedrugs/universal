
###操作系统：

#### 1. 进程间通信的方式？具体说说

#### 2. 进程调度算法有哪些？

url:http://www.xitongzhijia.net/xtjc/20171023/109740.html
1. 先来先服务 （FCFS，first come first served）
2. 最短作业优先（SJF， Shortest Job First）
3. 最高响应比优先法（HRRN，Highest Response Ratio Next）
4. 时间片轮转算法（RR，Round-Robin）
5. 多级反馈队列（Multilevel Feedback Queue）


#### 3. 线程消耗哪些资源？几个字节？

1. 一个线程分配1M的堆栈空间，用于局部变量和参数传递
2. 线程的ID，存放CPU寄存器相关的资源

#### 4. 虚拟内存？常见的页置换方法？（关注下LRU，CLOCK）

1. 虚拟内存的基本思想是：每个进程拥有自己的地址空间，这个空间被分割成多个块，每一块被称作一页或页面。每一页有连续的地址范围，这些页被映射到物理内存，
   但并不是所有的页都必须在内存中才能运行进程。 当进程需要用到不再物理内存的地址空间时，操作系统负责将缺失的部分装入物理内存。

2.
i. 最优置换算法( OPT):缺页中断发生时，对保存在内存中的每一个逻辑页面,计算在他下一次访问之前还需等待多长时间,从中选择等待时间最长的那个，作为被置换。
    
ii. 先进先出算法（FIFO):缺页中断发生时，系统选择在内存中驻留时间最长的页面淘汰。通常采用链表记录进入物理内存中的逻辑页面，链首时间最长。
该算法实现简单，但性能较差，调出的页面可能是经常访问的页面，而且进程分配物理页面数增加时，缺页并不一定减少(Belady现象)

#### 5. 堆和栈的区别？生命周期？
1. 堆栈空间分配
   
   栈（操作系统）：由操作系统自动分配释放 ，存放函数的参数值，局部变量的值等。其操作方式类似于数据结构中的栈。
   
   堆（操作系统）： 一般由程序员分配释放， 若程序员不释放，程序结束时可能由OS回收，分配方式倒是类似于链表。

2. 堆栈缓存方式

栈使用的是一级缓存， 他们通常都是被调用时处于存储空间中，调用完毕立即释放。

堆则是存放在二级缓存中，生命周期由虚拟机的垃圾回收算法来决定（并不是一旦成为孤儿对象就能被回收）。所以调用这些对象的速度要相对来得低一些。

3. 效率比较

栈由系统自动分配，速度较快。但程序员是无法控制的。

堆是由new分配的内存，一般速度比较慢，而且容易产生内存碎片,不过用起来最方便。

4. 存储内容

栈： 在函数调用时，在大多数的C编译器中，参数是由右往左入栈的，然后是函数中的局部变量。注意静态变量是不入栈的。
当本次函数调用结束后，局部变量先出栈，然后是参数，最后栈顶指针指向函数的返回地址，也就是主函数中的下一条指令的地址，程序由该点继续运行。

堆：一般是在堆的头部用一个字节存放堆的大小。堆中的具体内容由程序员安排。


#### 6. 死锁的四个条件？死锁预防，死锁避免，死锁检测？

#### 7. 不同的存储引擎是如何进行实际存储的？



怎么去分配聚簇索引和非聚簇索引
索引数据结构
为什么要用b+树
聚簇索引和非聚簇索引 （一开始说反了，后来突然意识到）
b+树叶子节点链表一定是放的是key和值吗？
为什么这么去分配
你的项目有很大量级吗，有做过数据库优化吗
这里实话实说没有，然后直接没问，但是是准备了这方面的知识的
然后问int存到数据库里面一般你都用什么类型来接
一开始说我自己项目里我全部是用varchar的，但是显然这样不是最优选择，可以看出来面试官有点迷惑（用varchar？！），最后说用int
顺着问varchar（35）的含义
一开始说错了，思考了一下，正确说出来了
又问了中文在varchar中占几个字符
回答了不同编码中中文所占字符应该不一样的，回答的2个，但实际是3个，后续面试官纠正的