package com.ryq.sharebike.util;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface CommnMapper<T> extends Mapper<T>,MySqlMapper<T> {

}
