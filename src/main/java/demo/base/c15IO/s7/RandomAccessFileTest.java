package demo.base.c15IO.s7;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileTest {
	public static void main(String[] args) {
		RandomAccessFile raf = null;
		try {
			// ��ֻ����ʽ��һ��RandomAccessFile����
			raf = new RandomAccessFile("RandomAccessFileTest.java", "r");
			// ��ȡRandomAccessFile�����ļ�ָ���λ�ã���ʼλ����0
			System.out.println("RandomAccessFile���ļ�ָ��ĳ�ʼλ�ã�"
					+ raf.getFilePointer());
			// �ƶ�raf���ļ���¼ָ���λ��
			raf.seek(300);
			byte[] bbuf = new byte[1024];
			// ���ڱ���ʵ�ʶ�ȡ���ֽ���
			int hasRead = 0;
			// ʹ��ѭ�����ظ���ȡˮ������
			while ((hasRead = raf.read(bbuf)) > 0) {
				// ȡ������Ͳ����ˮ�Σ��ֽڣ������ֽ�����ת�����ַ��������
				System.out.print(new String(bbuf, 0, hasRead));
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (raf != null) {
					raf.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

	}
}