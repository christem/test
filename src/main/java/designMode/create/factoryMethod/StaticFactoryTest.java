package designMode.create.factoryMethod;

/**
 * 静态工厂方法模式，将上面的多个工厂方法模式里的方法置为静态的，不需要创建实例，直接调用即可
 *
 */
public class StaticFactoryTest {

    public static void main(String[] args) {
	Sender mailsender = StaticSendFactory.produceMail();
	mailsender.Send();

	Sender smssender = StaticSendFactory.produceSms();
	smssender.Send();
    }
}
