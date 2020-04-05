package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.Book;
import com.example.demo.ReadingListRespository;

@Controller
@RequestMapping("/sa")
public class ReadingListController {

	private ReadingListRespository readingListRespository;

	@Autowired
	public ReadingListController(ReadingListRespository readingListRespository) {
		this.readingListRespository = readingListRespository;
	}

	@RequestMapping(value = "/{reader}", method = RequestMethod.GET)
	public String readersBooks(@PathVariable("reader") String reader, Model model) {
		System.out.println(reader);
		List<Book> readingList = readingListRespository.findByReader(reader);
		if (readingList != null) {
			model.addAttribute("books", readingList);
		}

		return "readingList";
	}

	@RequestMapping(value = "/{reader}", method = RequestMethod.POST)
	public String addToReadingList(@PathVariable("reader") String reader, Book book) {
		System.out.println("post :"+reader);
		book.setReader(reader);
		readingListRespository.save(book);
		return "redirect:/sa/{reader}";
	}


}
