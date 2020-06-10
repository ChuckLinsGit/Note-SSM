package annotation.services;

import javax.annotation.Resource;

import org.aspectj.lang.annotation.AdviceName;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import annotation.DAO.StudentDao;
import annotation.entity.Student;

@Service("StudentService")//ע��ʽ������ͬcontrollerһ���������������ļ�ʹ��context:component-scan��ǩ
public class StudentServiceImpl implements StudentService {

	/*@Autowired
	@Qualifier("StudentDao")*/
	
	//ע��ʽ����ʱ��dao��ע������MapperScannerConfigurer�Զ�������������������������Ҵ˴���������Ȼ����
	@Resource(name="studentDao")
	private StudentDao stuDao;
	

	public void setStuDao(StudentDao stuDao) {
		this.stuDao = stuDao;
	}


	@Override
	/*ʹ��Ĭ�ϵ���������*/
	@Transactional
	public void addStudent(Student stu) {
		stuDao.insertStu(stu);
	}

}
