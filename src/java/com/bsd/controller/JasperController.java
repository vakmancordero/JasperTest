package com.bsd.controller;

import com.bsd.model.DevolucionTDC;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;

/**
 *
 * @author VakSF
 */
public class JasperController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            
            List<DevolucionTDC> dataSource = this.getDataSourceTDC(200);
            
            this.export(dataSource, this.getDateTime());
            
            out.print("working");
            
        } catch (JRException ex) {
            Logger.getLogger(JasperController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private void export(List<DevolucionTDC> tdcDs, String dateTime) throws JRException {
        
        JRBeanCollectionDataSource dataSourcePDF = new JRBeanCollectionDataSource(tdcDs);
        
        Map parameters = new HashMap();
        
        String fileName = "Test_".concat(dateTime).concat(".pdf");
        
        String template = "C:/JasperTest/Templates/VISA_MC_PDF.jasper";
        
        String file = "C:/JasperTest/Results/" + fileName;
        
        JasperPrint pdfPrint = this.fillJasperPrint(template, parameters, dataSourcePDF);
        
        if (this.exportPDF(pdfPrint, file)) System.out.println("Archivo generado");
        
    }
    
    private JasperPrint fillJasperPrint(
            String template, Map parameters, JRBeanCollectionDataSource dataSource) throws JRException {
        
        return JasperFillManager.fillReport(template, parameters, dataSource);
    }
    
    private boolean exportPDF(JasperPrint jasperPrint, String absolutePath) throws JRException {
        
        try {
            
            JRExporter exporter = new JRPdfExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, absolutePath);

            exporter.exportReport();

            System.out.println("PDF creado: " + absolutePath);
    
            return true;
            
        } catch (JRException ex) {
            
            System.out.println("Exception: " + ex.toString());
            
            return false;
        }
        
    }
    
    private List<DevolucionTDC> getDataSourceTDC(int total) {
        
        ArrayList<DevolucionTDC> tdcDs = new ArrayList<DevolucionTDC>();

        for (int i = 0; i < total; i++) {
            
            DevolucionTDC devolucion = new DevolucionTDC();
            
            devolucion.setNumeroTarjeta("1234-5678-9012-345" + i);
            devolucion.setAfiliacion("724830" + i);
            devolucion.setFechaTransaccion(new Date());
            devolucion.setCodigoAutorizacion("00925" + i);
            devolucion.setImporteOriginal(new BigDecimal(1));
            devolucion.setImporteDevolver(new BigDecimal(1));
            
            devolucion.setFormaPago("TDC");
            devolucion.setTotal(new BigDecimal(1));
            
            tdcDs.add(devolucion);
            
        }
        
        System.out.println("\nDataSource [TDC]: " + tdcDs);
        
        return tdcDs;
    }
    
    private String getDateTime() {
        return new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss").format(new Date());
    }
    
    @Override
    public String getServletInfo() {
        return "Jasper Test";
    }

}
