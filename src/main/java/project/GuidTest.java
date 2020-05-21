package project;

import java.util.Date;

public class GuidTest {

    public void init(){
        /**
         * 1L       = 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0001
         * 反码     = 1111 1111 1111 1111 1111 1111 1111 1111 1111 1111 1111 1111 1111 1111 1111 1110
         * 补码     = 1111 1111 1111 1111 1111 1111 1111 1111 1111 1111 1111 1111 1111 1111 1111 1111
         * << 12L   = 1111 1111 1111 1111 1111 1111 1111 1111 1111 1111 1111 1111 1111 0000 0000 0000   << 位数向左移
         * -1L      = 1111 1111 1111 1111 1111 1111 1111 1111 1111 1111 1111 1111 1111 1111 1111 1111
         * -1L^     = 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 1111 1111 1111   ^ 对应为相同则为0，不同则为1
         *
         * ~        = 1111 1111 1111 1111 1111 1111 1111 1111 1111 1111 1111 1111 1111 0000 0000 0000     ~操作，所有位数取反
         *
         * 反码     = 1000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 1111 1111 1111     反码操作最高符号位为1，就不变，否则取反
         * 补码     = 1000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0001 0000 0000 0000     补码操作加1
         *
         * 反码     = 1111 1111 1111 1111 1111 1111 1111 1111 1111 1111 1111 1111 1110 1111 1111 1111
         * 补码     = 1111 1111 1111 1111 1111 1111 1111 1111 1111 1111 1111 1111 1111 0000 0000 0000
         * >>12L    = 1111 1111 1111 1111 1111 1111 1111 1111 1111 1111 1111 1111 1111 1111 1111 1111   >> 位数向右移，有符号位移，最高位符号位不变
         *
         * 反码     = 1111 1111 1111 1111 1111 1111 1111 1111 1111 1111 1111 1111 1110 1111 1111 1111
         * 补码     = 1111 1111 1111 1111 1111 1111 1111 1111 1111 1111 1111 1111 1111 0000 0000 0000
         * >>>12L   = 0000 0000 0000 1111 1111 1111 1111 1111 1111 1111 1111 1111 1111 1111 1111 1111   >>> 位数向右移，无符号位移，最高位补0
         *
         * jjj&kkk  = 0000 0000 0000 1111 1111 1111 1111 1111 1111 1111 1111 1111 1111 1111 1111 1111   & 对应位都为1则结果为1，否则为0
         * jjj|kkk  = 1111 1111 1111 1111 1111 1111 1111 1111 1111 1111 1111 1111 1111 1111 1111 1111   | 对应位都为0则结果为0，否则为1
         *
         * 1L    = 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0001
         * >>2   = 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000
         *
         * -1L    = 1000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0001      负数在进行位运算时，需要先进行补码操作
         * 反码   = 1111 1111 1111 1111 1111 1111 1111 1111 1111 1111 1111 1111 1111 1111 1111 1110
         * 补码   = 1111 1111 1111 1111 1111 1111 1111 1111 1111 1111 1111 1111 1111 1111 1111 1111
         * >>>2   = 0011 1111 1111 1111 1111 1111 1111 1111 1111 1111 1111 1111 1111 1111 1111 1111
         *
         * ~      = 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000
         *
         * -3L    = 1000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0011
         * 反码   = 1111 1111 1111 1111 1111 1111 1111 1111 1111 1111 1111 1111 1111 1111 1111 1100
         * 补码   = 1111 1111 1111 1111 1111 1111 1111 1111 1111 1111 1111 1111 1111 1111 1111 1101
         * ~      = 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0010
         */


        long hhh = -1L ^ (-1L << 12L);
        System.out.println("hhh = " + hhh);

        long iii = (~hhh);
        System.out.println("iii = " + iii);

        long jjj = iii >> 12L;
        System.out.println("jjj = " + jjj);

        long kkk = iii >>> 12L;
        System.out.println("kkk = " + kkk);

        long lll = jjj & kkk;
        System.out.println("lll = " + lll);

        long mmm = jjj | kkk;
        System.out.println("mmm = " + mmm);

        long nnn = 1L >> 2L;
        System.out.println("nnn = " + nnn);

        long ooo = (-1L) >>> 2L;
        System.out.println("ooo = " + ooo);

        long ppp = ~(-1L);
        System.out.println("ppp = " + ppp);

        long rrr = ~(-3L);
        System.out.println("rrr = " +rrr);

        long guid = nextId();
        System.out.println("guid = " + guid);

        int ccccc = Math.floorMod(1,5);
        System.out.println("ccccc = " + ccccc );

        long timestamp = restore(455948434839457792L);
        System.out.println("timestamp = " + timestamp);

    }

    private final long twepoch = 1468976307657L; // 2016/7/20 8:58:27.657
    private final long workerIdBits = 10L;
    private final long sequenceBits = 12L;
    private final long workerIdShift = sequenceBits;
    private final long timestampLeftShift = sequenceBits + workerIdBits;
    private final long sequenceMask = -1L ^ (-1L << sequenceBits);
    private long workerId;
    private long sequence = 0L;
    private long lastTimestamp = -1L;

    /**
     * timestamp to guid
     *
     * timestamp:           0000 0000 0000 0000 0000 0001 0110 1111 0001 1100 0010 1001 0001 0000 1110 1011
     * sequenceMask:        0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 1111 1111 1111
     * twepoch:             0000 0000 0000 0000 0000 0001 0101 0110 0000 0101 1100 1111 1001 1101 1100 1001
     * timestampLeftShift:  0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0001 0110
     *
     * lastTimestamp:       0000 0000 0000 0000 0000 0001 0110 1111 0001 1100 0010 1001 0001 0000 1110 1011
     * timestamp-twepoch:   0000 0000 0000 0000 0000 0000 0001 1001 0001 0110 0101 1001 0111 0011 0010 0010
     * (timestamp - twepoch) << timestampLeftShift = aaa:
     *                      0000 0110 0100 0101 1001 0110 0101 1100 1100 1000 1000 0000 0000 0000 0000 0000
     *
     * workerId:            0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000
     * workerId << workerIdShift = bbb:
     *                      0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000
     * aaa|bbb = ccc:       0000 0110 0100 0101 1001 0110 0101 1100 1100 1000 1000 0000 0000 0000 0000 0000
     *
     * sequence:            0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000
     * ccc|sequence = ddd:  0000 0110 0100 0101 1001 0110 0101 1100 1100 1000 1000 0000 0000 0000 0000 0000
     *
     * sequenceMask:        0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 1111 1111 1111
     * sequence+1:          0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0001
     * (sequence+1) & sequenceMask = eee:
     *                      0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0001
     * ccc =                0000 0110 0100 0101 1001 0110 0101 1100 1100 1000 1000 0000 0000 0000 0000 0000
     * ccc|eee:             0000 0110 0100 0101 1001 0110 0101 1100 1100 1000 1000 0000 0000 0000 0000 0001
     *
     */
    public synchronized long nextId() {
        long timestamp = timeGen();
        if (timestamp < lastTimestamp) {
            throw new RuntimeException(
                    String.format("Clock moved backwards.  Refusing to generate id for %d milliseconds",
                            lastTimestamp - timestamp));
        }
        if (lastTimestamp == timestamp) {
            sequence = (sequence + 1) & sequenceMask;
            if (sequence == 0) {
                timestamp = tilNextMillis(lastTimestamp);
            }
        } else {
            sequence = 0L;
        }

        lastTimestamp = timestamp;

        return ((timestamp - twepoch) << timestampLeftShift) | (workerId << workerIdShift)
                | sequence;
    }

    public long tilNextMillis(long lastTimestamp) {
        long timestamp = timeGen();
        while (timestamp <= lastTimestamp) {
            timestamp = timeGen();
        }
        return timestamp;
    }


    /**
     * guid to timestamp
     * guid:                        0000 0110 0100 0101 1001 0110 0101 1100 1100 1000 1000 0000 0000 0000 0000 0000
     * timestampLeftShift:          0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0001 0110
     * guid >> timestampLeftShift : 0000 0000 0000 0000 0000 0000 0001 1001 0001 0110 0101 1001 0111 0011 0010 0010
     */

    public long restore(long guid) {
        return (guid
                >> timestampLeftShift) + twepoch;
    }

    public Date restoreDate(long time){
        return new Date(time);
    }

    private long timeGen() {
        return System.currentTimeMillis();
    }

}
