package com.busbooking.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.servlet.ModelAndView;

import com.busbooking.model.BookingInfo;
import com.busbooking.model.Passenger;
import com.busbooking.service.BusService;
import com.busbooking.util.DBUtil;
import com.busbooking.util.DateTimeUtil;

@Controller
public class DefaultController implements ServletContextAware{
	 
	public static String realPath;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView login() {
		return "anonymousUser".equalsIgnoreCase(getUserName()) ? new ModelAndView("user") : showHomeInfo();
	}

	@RequestMapping(value = "/loginfail", method = RequestMethod.GET)
	public String loginfail() {
		return "error";
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ModelAndView showHomeInfo() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("date", DateTimeUtil.getDateStr());
		map.put("time", DateTimeUtil.getTimeStr());
		map.put("BookingInfo", new BookingInfo());
		map.put("fromCity", BookingInfo.CITIES);

		List<String> list = new ArrayList<String>(BookingInfo.CITIES);
		Collections.shuffle(list);
		map.put("toCity", list);

		return new ModelAndView("home", map);
	}

	@RequestMapping(value = "/result", method = RequestMethod.POST)
	public ModelAndView searchBus(
			@ModelAttribute("BookingInfo") BookingInfo info, ModelMap model) {
		Map<String, Object> map = new HashMap<String, Object>(3);

		if (info != null) {
			map.put("searchresult", BusService.search(info));
		}
		return new ModelAndView("result", map);
	}

	@RequestMapping(value = "/booking", method = RequestMethod.GET)
	public ModelAndView doBooking( ModelMap model) {
		return new ModelAndView("booking");
	}
	
	
	@RequestMapping(value = "/mybookings", method = RequestMethod.GET)
	public ModelAndView myBooking(ModelMap model) {
		Map<String, Object> map = new HashMap<String, Object>(3);
		String name = getUserName();
		if("admin".equalsIgnoreCase(name)){
			map.put("mylist", DBUtil.getAllBookings());
		}
		else{
			map.put("mylist", DBUtil.getUserBookings(name));
		}
		return new ModelAndView("mybookings",map);
	}

	private String getUserName() {
		String name = SecurityContextHolder
				.getContext().getAuthentication().getName();
		return name;
	}
	
	@RequestMapping(value = "/confirm", method = RequestMethod.POST)
	public ModelAndView confirm(
			@ModelAttribute("Passenger") Passenger passenger, ModelMap model) {
		BusService.updateBooking(passenger,false);
		return new ModelAndView("confirm");
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView deleteBooking(ModelMap model, @RequestParam int bookingId) {
		
		for(Passenger p : DBUtil.getAllBookings()){
			if(p.getBookingId()	==	bookingId){
				BusService.updateBooking(p,true);
				return myBooking(model);
			}
		}
		return myBooking(model);
	}

	@Override
	public void setServletContext(ServletContext sc) {
		realPath = sc.getRealPath("/");
		DBUtil.loadDB(realPath);
	}
}
