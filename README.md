# expandedrecycleviewdemo
一般网上很多人，RecycleView Item展开的效果的思路就是通过item的add和remove来实现，但是图中的效果会出现哪些问题呢？
* 每个item是有圆角的
* 每个item是有间距的

如果也是通过add和remove来实现，怎么保证下拉的那部分内容的间距是没有的，又怎么保证圆角一直会往下移动。都是比较麻烦的，也不是说一定没有办法。总之处理起来比较恶心。不过并不是这种方案不好，毕竟没有万能的方案，只有适合的方案。

__add和remove来实现的方案可以参考下面几篇文章__

[Android -- RecyclerView（超简单）实现可展开列表](https://juejin.im/entry/58fd730eb123db74d87dbe9e)

[ExpandableRecyclerview](https://github.com/zaihuishou/ExpandableRecyclerview)

[expandable-recycler-view](https://github.com/bignerdranch/expandable-recycler-view)


好，下面是我的思路。

- 外围控件就是简单的RecycleView
- recycleView里的item的父view是cardview，为了方便的支持圆角
- 点击下拉说白了就是简单的一个visiable以及gone的动画效果。
