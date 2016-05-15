package demo.base.c15IO.s10;

import java.io.FileOutputStream;
import java.nio.charset.Charset;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FilesTest {
	public static void main(String[] args) throws Exception {
		String path = "E:/Code/MyGitProject/Test/src/main/java/demo/base/c15IO/s10/";

		// 复制文件
		Files.copy(Paths.get(path + "FilesTest.java"), new FileOutputStream(
				path + "a.txt"));
		// 判断FilesTest.java文件是否为隐藏文件
		System.out.println("FilesTest.java是否为隐藏文件："
				+ Files.isHidden(Paths.get(path + "FilesTest.java")));
		// 一次性读取FilesTest.java文件的所有行
		List<String> lines = Files.readAllLines(
				Paths.get(path + "FilesTest.java"), Charset.forName("gbk"));
		System.out.println(lines);
		// 判断指定文件的大小
		System.out.println("FilesTest.java的大小为："
				+ Files.size(Paths.get(path + "FilesTest.java")));
		List<String> poem = new ArrayList<String>();
		poem.add("水晶潭底银鱼跃");
		poem.add("清徐风中碧竿横");
		// 直接将多个字符串内容写入指定文件中
		Files.write(Paths.get(path + "pome.txt"), poem, Charset.forName("gbk"));
		FileStore cStore = Files.getFileStore(Paths.get("C:"));
		// 判断C盘的总空间，可用空间
		System.out.println("C:共有空间：" + cStore.getTotalSpace());
		System.out.println("C:可用空间：" + cStore.getUsableSpace());
	}
}
