package com.processor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component("itemWriter")
public class StudentWriter implements ItemWriter {

@Autowired
private StudentDao itemDAO;
public Integer totalCount = null;
static int i = 0;
LinkedHashSet<String> setStudent = new LinkedHashSet<String>();//create a set...
private static final Log log = LogFactory.getLog(StudentWriter.class);	
	public void write(List items) throws Exception {
	
	  for (Iterator<Student> iterator = items.iterator(); iterator.hasNext();)
	  {
              Student item = iterator.next();
              setStudent.add(item.getClass()+item.getSection()+item.getGrade()+item.getPin());
      }
   //   System.out.println("set size..."+setOptProvider.size());
      
      Iterator it = setStudent.iterator();
      while (it.hasNext()) 
      {
		      String row = (String) it.next();
		     // System.out.println("row from set..."+row);
               for (Iterator<Student> iterator = items.iterator(); iterator.hasNext();) 
                    {
				          Student item = iterator.next();
				          String strdatabaserow=itemDAO.findByProviderId(item.class_id(),item.getSection(),item.getGrade(),item.getPin());
                          //System.out.println("strdatabaserow..."+strdatabaserow);
                        //  System.out.println("item.getAmisys_prov_id()+item.getTax_id()+item.getTax_id_suff()+item.getMpin()..."+item.getAmisys_prov_id()+item.getTax_id()+item.getTax_id_suff()+item.getMpin());
                               if (row.equals(item.class_id()+item.getSection()+item.getGrade()+item.getPin()))
                               {
        	                       // System.out.println("inside if..."+strdatabaserow);
                                    if(strdatabaserow.equals("")){
                                    itemDAO.save(item);
                                    break;
                                }
                  
                      }
        }
}

}
}