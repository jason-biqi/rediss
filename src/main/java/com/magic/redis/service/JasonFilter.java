package com.magic.redis.service;

import java.io.*;

/**
 * @author jiaosong
 * @version V1.0
 * @ClassName:JasonFilter
 * @Description: TODO
 * @Date 10:57
 */
public class JasonFilter extends FilterWriter {


    /**
     * Create a new filtered writer.
     *
     * @param out a Writer object to provide the underlying stream.
     * @throws NullPointerException if <code>out</code> is <code>null</code>
     */
    protected JasonFilter(Writer out) {
        super(out);
    }
}
