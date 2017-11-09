package com.cfq.demo.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cfq.demo.entity.User;
import com.cfq.demo.service.UserService;

@Controller
@RequestMapping(value = "/page")
public class ShowIndex {
	@Resource
	private UserService userService;

	@RequestMapping(value = "/index.do")
	public String goIndex() {
		return "/FirstPage";
	}
	@RequestMapping(value="/export/excel")
	public void exportExcel(HttpServletRequest request,HttpServletResponse response) throws IOException{
		// 1.创建一个workbook，对应一个Excel文件
        HSSFWorkbook workBook = new HSSFWorkbook();
        // 2.在workbook中添加一个sheet，对应Excel中的一个sheet
        HSSFSheet sheet = workBook.createSheet("用户信息表");
        // 3.在sheet中添加表头第0行，老版本poi对excel行数列数有限制short
        HSSFRow row = sheet.createRow((int) 0);
        // 4.创建单元格，设置值表头，设置表头居中
//        HSSFCellStyle style = workBook.createCellStyle();
        HSSFCellStyle style=getFirstStyle(workBook);
        // 居中格式
        style=getTitleStyle(workBook);
        style=setTableStyle(workBook);
        style=setContentStyle(workBook);
        style=setFootStyle(workBook);
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        

        // 设置表头
        HSSFCell cell = row.createCell(0);
        cell.setCellValue("用户名");
        cell.setCellStyle(style);

        cell = row.createCell(1);
        cell.setCellValue("密码");
        cell.setCellStyle(style);

        cell = row.createCell(2);
        cell.setCellValue("更新时间");
        cell.setCellStyle(style);

        cell = row.createCell(3);
        cell.setCellValue("添加时间");
        cell.setCellStyle(style);

        cell = row.createCell(4);
        cell.setCellValue("添加人");
        cell.setCellStyle(style);
        List<User> lists= userService.getAllUser();
        for (int i = 0; i < lists.size(); i++) {
            row = sheet.createRow((int) i + 1);
            User user= lists.get(i);
            // 创建单元格，设置值
            row.createCell(0).setCellValue(user.getUserName());
            row.createCell(1).setCellValue(user.getPassWord());
            row.createCell(2).setCellValue(user.getUpdateTime());
            row.createCell(3).setCellValue(user.getAddTime());
            row.createCell(4).setCellValue(user.getAddPeople());
        }
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        workBook.write(os);
        byte[] content = os.toByteArray();
        InputStream is = new ByteArrayInputStream(content);
        // 设置response参数，可以打开下载页面
        response.reset();
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename="
                + new String(("用户信息.xls").getBytes("gb2312"), "iso8859-1"));
        ServletOutputStream out = response.getOutputStream();
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            bis = new BufferedInputStream(is);
            bos = new BufferedOutputStream(out);
            byte[] buff = new byte[2048];
            int bytesRead;
            // Simple read/write loop.
            while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
                bos.write(buff, 0, bytesRead);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            if (bis != null)
                bis.close();
            if (bos != null)
                bos.close();
        }
	}
	
	
	 /** 
     * 第一行的样式 
     *  
     * @return 
     */  
    public HSSFCellStyle getFirstStyle(HSSFWorkbook workBook) {  
  
        HSSFCellStyle style = workBook.createCellStyle();  
        HSSFFont font = workBook.createFont();  
        font.setFontName("Arial");  
        font.setFontHeightInPoints((short) 18);// 设置字体大小  
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);  
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 左右居中  
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 上下居中  
        style.setWrapText(true);  
        style.setFont(font);  
        return style;  
    }  
  
    /** 
     * 标题行样式 
     *  
     * @return 
     */  
    public HSSFCellStyle getTitleStyle(HSSFWorkbook workBook) {  
  
        HSSFCellStyle style = workBook.createCellStyle();  
        HSSFFont font = workBook.createFont();  
        font.setFontName("Arial");  
        font.setFontHeightInPoints((short) 12);// 设置字体大小  
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);  
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 左右居中  
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 上线居中  
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);  
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);  
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);  
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);  
        style.setWrapText(true);  
        style.setFont(font);  
        return style;  
    }  
  
    /** 
     * 蓝色样式 
     *  
     * @return 
     */  
    public HSSFCellStyle getTitleStyle(short index,HSSFWorkbook workBook) {  
  
        HSSFCellStyle style = workBook.createCellStyle();  
        HSSFFont font = workBook.createFont();  
        font.setFontName("Arial");  
        font.setFontHeightInPoints((short) 12);// 设置字体大小  
        font.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);  
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 左右居中  
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 上线居中  
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);  
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);  
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);  
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);  
        style.setWrapText(true);  
        style.setFont(font);  
        style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);  
        style.setFillForegroundColor(index);  
        return style;  
    }  
  
    /** 
     * 表格样式 
     *  
     * @return 
     */  
    public HSSFCellStyle setTableStyle(HSSFWorkbook workBook) {  
  
        HSSFCellStyle style = workBook.createCellStyle();  
        HSSFFont font = workBook.createFont();  
        font.setFontName("Arial");  
        font.setFontHeightInPoints((short) 12);// 设置字体大小  
        font.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);  
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 左右居中  
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 上线居中  
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);  
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);  
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);  
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);  
        style.setWrapText(true);  
        style.setFont(font);  
        return style;  
    }  
  
    /** 
     * 文本样式 
     *  
     * @return 
     */  
    public HSSFCellStyle setContentStyle(HSSFWorkbook workBook) {  
        HSSFCellStyle style = workBook.createCellStyle();  
        HSSFFont font = workBook.createFont();  
        font.setFontName("Arial");  
        font.setFontHeightInPoints((short) 12);  
        font.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);  
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 左右居中  
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 上线居中  
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);  
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);  
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);  
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);  
        style.setWrapText(true);  
        style.setFont(font);  
        return style;  
    }  
  
    /** 
     * 底部，签名样式 
     *  
     * @return 
     */  
    public HSSFCellStyle setFootStyle(HSSFWorkbook workBook) {  
  
        HSSFCellStyle style = workBook.createCellStyle();  
        HSSFFont font = workBook.createFont();  
        font.setFontName("Arial");  
        font.setFontHeightInPoints((short) 11);// 设置字体大小  
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);  
        style.setAlignment(HSSFCellStyle.ALIGN_RIGHT);  
        style.setFont(font);  
        return style;  
    }  

}
