package java_ncs_exam.dao;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java_ncs_exam.dao.impl.TitleDaoImpl;
import java_ncs_exam.dto.Title;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TitleDaoTest {
	private static TitleDao dao = TitleDaoImpl.getInstane();

	@After
	public void tearDown() throws Exception {
		System.out.println();
	}

	@Test
	public void test03SelectTitleByAll() {
		System.out.printf("%s()%n","test03SelectTitleByAll");
		List<Title> titleList = dao.selectTitleByAll();
		Assert.assertNotNull(titleList);
		
		for(Title t : titleList) {
			System.out.println(t);
		}
	}

	@Test
	public void test05SelectTitleByNo() {
		System.out.printf("%s()%n","test05SelectTitleByNo");
		Title title = new Title(1);
		Title searchTitle = dao.selectTitleByNo(title);
		Assert.assertNotNull(searchTitle);
		System.out.println(searchTitle);
	}

	@Test
	public void test01InsertTitle() {
		System.out.printf("%s()%n","test01InsertTitle");
		Title newTitle = new Title(6,"인턴");
		int res = dao.insertTitle(newTitle);
		Assert.assertEquals(1, res);
		System.out.println(newTitle);
	}

	@Test
	public void test02UpdateTitle() {
		System.out.printf("%s()%n","test02UpdateTitle");
		Title newTitle = new Title(6,"테스트");
		int res = dao.updateTitle(newTitle);
		Assert.assertEquals(1, res);
		System.out.println(dao.selectTitleByNo(newTitle));
	}

	@Test
	public void test04DeleteTitle() {
		System.out.printf("%s()%n","test04DeleteTitle");
		int res = dao.deleteTitle(6);
		Assert.assertEquals(1, res);
		System.out.println("Delte Complete");
		dao.selectTitleByAll().stream().forEach(System.out::println);
	}

}
