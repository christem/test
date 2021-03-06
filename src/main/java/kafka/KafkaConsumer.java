package kafka;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;
import kafka.message.MessageAndMetadata;

public class KafkaConsumer extends Thread {
	private final ConsumerConnector consumer;
	private final String topic;

	public KafkaConsumer(String topic) {
		consumer = kafka.consumer.Consumer
				.createJavaConsumerConnector(createConsumerConfig());
		this.topic = topic;
	}

	private static ConsumerConfig createConsumerConfig() {
		Properties props = new Properties();
		// zookeeper 配置
		props.put("zookeeper.connect", KafkaProperties.zkConnect);
		// group 代表一个消费组
		props.put("group.id", KafkaProperties.groupId);
		// zk连接超时
		props.put("zookeeper.session.timeout.ms", "40000");
		// props.put("zookeeper.sync.time.ms", "200");
		props.put("auto.commit.interval.ms", "1000");
		return new ConsumerConfig(props);
	}

	@Override
	public void run() {
		Map<String, Integer> topicCountMap = new HashMap<String, Integer>();
		topicCountMap.put(topic, new Integer(1));
		Map<String, List<KafkaStream<byte[], byte[]>>> consumerMap = consumer
				.createMessageStreams(topicCountMap);
		KafkaStream<byte[], byte[]> stream = consumerMap.get(topic).get(0);
		ConsumerIterator<byte[], byte[]> it = stream.iterator();
		while (it.hasNext()) {
			MessageAndMetadata mam = it.next();
			System.out.println("consume: Partition [" + mam.partition()
					+ "] Message: [" + new String(mam.message() + "") + "] ..");
			try {
				sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
