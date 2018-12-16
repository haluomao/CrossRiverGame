# 一、项目简介

老虎过河小游戏，需要将所有老虎用一艘船从南岸运到北岸，途中要保证小老虎不会被大老虎吃掉。

## 1. 游戏背景
有三对老虎母子要过河，河里只有一条船。现在的情况比较糟，因为已经几天没有吃东西了，所以对小老虎来说，其它母老虎都是危险的敌人。
所以不能让小老虎在离开母亲的情况下与其它母老虎呆在一处。

过河唯一的途径是坐船，当然船上有会划船的老虎，船才能开动。现在除了三只母老虎会划船外，其中还有一只小老虎也会划船，但船比较小，最多只能坐二只老虎。
当然离开岸的船，只能等对岸的船回来后，才能登陆了。

## 2. 快速开始
有代码可以直接运行Main.java

发布命令：gradle jar

会在outout/libs文件夹下生成jar文件。

运行： java -jar codeartc_tiger-1.0.0.jar

## 3. 游戏操作介绍

游戏的主界面

    Tiger sailors: A B C b
    ------------------------------
    NORTH:
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    ~~~~~~~~~~~~\____/~~~~~~~~~~~~
    SOUTH: A B C a b c
    ------------------------------
    Onboard：B b

其中Onboard后面是输入，游戏通关后会告诉通关用时，并重新开始。

# 二、项目设计

项目的设计过程可以理解成一场舞台剧演出。
在这个演出中，主角是六只老虎，船是道具，两个河岸是场景，演出的目标就是让六只饥饿的老虎安全地从南岸到达北岸。

另外，还有些默默付出的幕后人员：

- 一个大导演：能发号施令，指导整场演出。
- 一个报幕员：播报场景状态（负责打印所有信息），包括老虎在哪里，是否有血案，游戏用时等。
- 一个制片人：完成导演的命令，比如把船开到对岸，检查场景是否安全等。
- 一个保洁员：当演出开始或出现血案要复位的时候，清理现场，把道具都复位。

玩家相当于编剧。游戏玩赢了就是喜剧剧情，玩输了就是狗血剧情。

## 2.1 设计模式的作用和目的
用到这几种设计模式：builder、factory method、singleton、command、observer、state、memento、facade

- builder: 用于组装（饲养）主角和打造道具。
builder设计模式主要用在构造实体类的实例，支持链式调用Builder类中的成员函数，构造简单，并使代码可读性大大增强。

- factory method: 工厂方法模式用于集中化搭建舞台、创造道具、招募各种幕后人员。
主要目的是封装类中不变的部分，提取其中个性化善变的部分为独立类，通过依赖注入以达到解耦、复用和方便后期维护拓展的目的。

- singleton: 该模式用于工厂方法和搭建舞台，用同一个工厂和同一个舞台，能节省演出经费。
通过单例模式可以保证系统中，应用该模式的类一个类只有一个实例。即一个类只有一个对象实例。

- command: 命令模式将大导演的一串动作都封装成一个言简意赅的指令，比如action表示让制片人开船，至于制片人怎么防止被老虎吃、
怎么把船开到对岸、怎么把老虎赶下船，大导演通通不用管。
行为请求者与行为实现者之间通常呈现一种紧耦合的关系，而使用command模式将行为请求者与行为实现者进行解耦。

- observer: 报幕员和保洁员是观察者，制片人是被观察者。在制片人执行导演命令时，如果遇到异常状态，会通知观察者做事。
比如当船上没有能划船的老虎时，就通知观察者，观察者接受到通知后，打印提示信息，让玩家重新输入。
该模式定义了对象间的一对多的依赖关系,当一个对象的状态发生改变时, 所有依赖于它的对象都得到通知并被自动更新。

- state: 整个舞台有三个状态：开始状态，开演状态（开船状态）和结束状态。由于交互是控制台的缘故，就忽略了开船前的准备状态。
状态的迁移都由导演来改变。
允许一个对象在其内部状态改变时改变它的行为。用状态的迁移更利于人去理解程序，而且将动作按状态来归组分类，不易出错。

- memento：备忘录模式用于存储初始场景，保洁员『看一眼』备忘录，就能快速布置好初始场景。
在不破坏封闭的前提下，捕获一个对象的内部状态，并在该对象之外保存这个状态。这样以后就可将该对象恢复到原先保存的状态。

- facade: 仅提供两个函数——show()和sail()——给外部调用，能封装大部分的实现。
该模式为子系统中的各类提供一个简明一致的界面，隐藏子系统的复杂性，使子系统更加容易使用。

# 三、游戏实现

基于Java8和Guava。

主要逻辑实现用了两个小时；注入设计模式用了五个小时。

(本项目是《代码的艺术》课程的作业，要求尽可能多地运用设计模式，我独立负责该项目的设计和实现，拥有全部代码版权）