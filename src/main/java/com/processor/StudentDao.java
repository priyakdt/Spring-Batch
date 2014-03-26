package com.processor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public interface StudentDao {
static final Log log = LogFactory.getLog(StudentDao.class);

public void save(final Student item);

public String findByProviderId(String Class_id,String Section,String Grade,String pin);


}
