//package org.lee.prescription.util;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationListener;
//import org.springframework.context.event.ContextRefreshedEvent;
//import org.springframework.stereotype.Component;
//
///**
// * @ClassName MyContextListener
// * @Description ����spring������ʼ������¼�������spring������ʼ����ɺ��ȡ���ñ��ȡ������
// * 				���ظ���������е�����
// * @Date 2015��7��23�� ����2:56:13
// * @author lijw
// *
// */
//@Component("myContextListener")
//public class MyContextListener implements ApplicationListener<ContextRefreshedEvent>{
//	
//	@Autowired
//	private CodeCacheService codeService;
//	
//	
//	/**
//	 * ����spring�������ػ���ˢ���¼�����spring�����������ʱִ�и÷���
//	 */
//	public void onApplicationEvent(ContextRefreshedEvent event) {
//		System.out.println("my listener");
//		try {
//			//��ȡ��������ñ�
//			List<DmbConftbl> dmbs = codeService.getDmbbm();
//			//������������ñ���ȡ���еĴ����ı��������ձ������ض�ȡ������е����ݲ����ص�������
//			for (DmbConftbl dmbConftbl : dmbs) {
//				String code = codeService.getDm(dmbConftbl.getDmbbm(),"");
//			}
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//			e.printStackTrace();
//		}
//	}
//	
//	
//	
//	
//
//}
//
//
//
//
//
//
//
//
