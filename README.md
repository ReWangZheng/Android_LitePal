# LitePal操作数据库   
#### LitePal简介：   
>	LitePal是一款开源的Andrid数据库框架，采用了关系型映射模型，将我们平时开发常用到的一些数据库功能进行了封装

#### 一．	配置LitePal 
&emsp;&emsp;因为LitePai是开源库，所以我们要在gradle文件的dependencies添加依赖
**Compile ‘org.litepal.android:core:1.3.2’**，添加完之后，我们要在**src/main**目录下创建一个**assets**目录，在里面创建**litepal.xml**,并且配置如下内容:
>
			<litepal> 
			    <dbname value=”XXX”></dbname>  (用于指定数据库名)
				<version value=”x”></version>       (用于指定数据库版本)
				<list></list>						  (映射模型)
 	</litepal>
   	
&emsp;&emsp;最后我们要在**AndroidManifest.xml**文件中配置一下，在 **<application>** 标签中添加属性
       
    <android:name=”org.litepal.LitePalApplication”/>   
        
        
#### 二、使用LitePal添加数据    

&emsp;&emsp;如果我们想使用LitePal的添加数据功能，那么我们就必须让我们的映射类继承DataSupport类，然后直接新建出映射类，然后使用seter来设置各种值，设置完成之后，我们在调DataSurport类提供的save()方法进行保存

三、使用LitePal更新数据
		我们对LitePal进行更新数据，这个映射类的状态必须是已保存的，那么什么情况下这个状态是已保存呢？要么是从数据库里查询出来的，要么就是已经调用过sava()的，我们使用set来对数据进行更新，最后在调用save就好啦！
		还有一种更加灵巧的方式，直接新建一个映射对象，对映射对象修改好值之后，在调用映射对象继承DataSurport类里的方法updateAll(String,String….),第一个参数就是限定值比如 “name=?  author=?”,后面的参数都是对?赋值
	 

#### 三、删除数据
&emsp;&emsp;第一种就是直接调用映射对象的**delete()**方法就可以了，第二种就是使用**DataSupport**类的静态方法**deleteAll(Class,String…)**，第一个参数就是映射对象类的class，后面的参数与**updateAll()** 一样，都是进行限制的。

#### 四、查询数据
&emsp;&emsp;我们直接使用**DataSupport.findAll(Class)**即可查询到所有数据，并将JAVABEAN封装成一个**List<Class>**表存储起来，我们可以通过list来访问各个对象，初次之外，我们还可以进行筛选,比如

>       DataSupport.where(“name=张凯”).orderby(“score desc”).limit(3).find(Class);

来进行多重筛选。

