/**
 * 2008-4-16 上午09:38:29
 * 和志刚
 */
package com.codeguru;

import java.lang.annotation.*;

/**
 *Criticize 注释类型
 */
@Retention(RetentionPolicy.SOURCE)
public @interface Criticize {
	String rank();
	String feel();
}
