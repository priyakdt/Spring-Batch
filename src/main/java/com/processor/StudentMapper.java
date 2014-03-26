package com.processor;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.stereotype.Component;

@Component("optionsMapper")
public class StudentMapper implements FieldSetMapper {
	private static final Log log = LogFactory.getLog(StudentMapper.class);
public Object mapFieldSet(FieldSet fs) 

{
	if(fs == null){
        return null;
}
		Student record = new Student();
		int idx = 0;
		record.setGrade(fs.readString(idx++));
	    record.setClass_id(fs.readString(idx++));
	    record.setSection(fs.readString(idx++));
	    record.setPin(fs.readString(idx++));
	
	    return record;
	    
}

}

