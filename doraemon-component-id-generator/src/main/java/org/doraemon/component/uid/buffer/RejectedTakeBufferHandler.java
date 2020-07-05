package org.doraemon.component.uid.buffer;

@FunctionalInterface
public interface RejectedTakeBufferHandler {

    /**
     * Reject take buffer request
     * 
     * @param ringBuffer
     */
    void rejectTakeBuffer(RingBuffer ringBuffer);
}
