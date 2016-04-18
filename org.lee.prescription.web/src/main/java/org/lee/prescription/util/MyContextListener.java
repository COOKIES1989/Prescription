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
// * @Description 监听spring容器初始化完毕事件，且在spring容器初始化完成后读取配置表获取表名，
// * 				加载各个代码表中的数据
// * @Date 2015年7月23日 下午2:56:13
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
//	 * 监听spring容器加载或者刷新事件，在spring容器加载完成时执行该方法
//	 */
//	public void onApplicationEvent(ContextRefreshedEvent event) {
//		System.out.println("my listener");
//		try {
//			//读取代码表配置表
//			List<DmbConftbl> dmbs = codeService.getDmbbm();
//			//遍历代码表配置表，获取所有的代码表的表名，按照表名加载读取代码表中的数据并加载到缓存中
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
