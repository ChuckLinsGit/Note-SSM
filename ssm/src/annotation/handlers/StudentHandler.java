package annotation.handlers;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import annotation.entity.Student;
import annotation.services.StudentService;

@Controller
public class StudentHandler {

  /*��ɾ��spring-service.xml:��service����xml�ļ���ע��
   * @Autowired
	@Qualifier("StudentService")
	*/
	
	/*ɾ��spring-service.xml����Ҫ��resourceע�⣬����serviece�м���serviceע��*/
	@Resource(name="StudentService")
	private StudentService studetnService;

	public void setStudetnService(StudentService studetnService) {
		this.studetnService = studetnService;
	}

	@RequestMapping("test.do")
	public String  handleRequest(String name,int age,int score,int classid,Model model) throws Exception {

		Student stu=new Student(name, age, score, classid);
		
		ModelAndView mView=new  ModelAndView();
		
		if(stu!=null) {
			studetnService.addStudent(stu);
			model.addAttribute("Message", "�ɹ���ӣ�");			
		}else {
			model.addAttribute("Message", "���ʧ�ܣ�");			
		}
		return "/input.jsp";
	}


}
