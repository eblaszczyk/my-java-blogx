package pl.ebla.mjbx.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import pl.ebla.mjbx.entity.Month;
import pl.ebla.mjbx.repository.MonthRepository;

@Service
public class MonthService {
	
	@Autowired
	private MonthRepository monthRepository;
	
	public Month findByName(String name){
		
		return monthRepository.findByName(name);
	}
	
	public void save(Month month){
		
		monthRepository.save(month);
	}
	
	public void saveIfNotExists(Month month){
		
		if( findByName(month.getName()) == null )
			save(month);
	}

	public List<Month> findAllSortDesc(){
		
		return monthRepository.findAll(sortByStartDateDesc());
	}
	
    private Sort sortByStartDateDesc() {
        return new Sort(Sort.Direction.DESC, "startDate");
    }
    
}
