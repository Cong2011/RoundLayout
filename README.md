# RoundLayout[![](https://jitpack.io/v/Cong2011/RoundLayout.svg)](https://jitpack.io/#Cong2011/RoundLayout)
九宫格图片控件显示、编辑、拖拽排序

## 添加依赖：
Step 1. Add the JitPack repository to your build file
Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
Step 2. Add the dependency

	dependencies {
	        implementation 'com.github.Cong2011:RoundLayout:版本号'
	}

## 使用说明：
1、按上述步骤添加依赖，版本号看本文件顶部jitpack图标

2、当作FrameLayout使用（即：在layout/xml布局文件中，将需要设置圆角的控件，用RoundLayout布局包裹）

3、使用属性android:???Radius等、或代码setRadius(int)等方式设置圆角

## 其它说明：
1、极轻量

2、兼容Support、AndroidX，minSDK == 18

3、支持在布局文件layout\*.xml中使用android:radius等配置各圆角

权重 android:leftTopRadius等 > android:radius

4、支持在Java或Kotlin代码中，使用setRadius方法配置各圆角