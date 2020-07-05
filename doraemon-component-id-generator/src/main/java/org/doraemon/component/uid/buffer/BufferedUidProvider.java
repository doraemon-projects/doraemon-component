package org.doraemon.component.uid.buffer;

import java.util.List;

@FunctionalInterface
public interface BufferedUidProvider {

    /**
     * Provides UID in one second
     * 
     * @param momentInSecond
     * @return
     */
    List<Long> provide(long momentInSecond);
}
