package com.lis.exam;

import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.lis.exam.controller.AdminController;
import com.lis.exam.entity.SubjectArea;

import ch.qos.logback.core.status.Status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExamApplicationTests {
	
	@Autowired
	private MockMvc mokito;
	
	@Test
	public void test_get_all_subject_area() throws Exception {
		mokito.perform(MockMvcRequestBuilders.get("/api/admin/all-subject-area")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
		.andReturn();
	}

}
