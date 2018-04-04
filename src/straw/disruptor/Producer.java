package straw.disruptor;

import java.nio.ByteBuffer;

import com.lmax.disruptor.RingBuffer;

public class Producer {
	private final RingBuffer<PCData> ringBuffer;
	public Producer(RingBuffer<PCData> ringBuffer){
		this.ringBuffer=ringBuffer;
	}
	
	public void pushData(ByteBuffer bb){
		long sequence = ringBuffer.next();
		try{
			PCData event = ringBuffer.getPreallocated(sequence);
			event.set(bb.getLong());
		}finally{
			ringBuffer.publish(sequence);
		}
	}
}
