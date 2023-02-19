package com.example.bidv_echo_server.controller;

import com.example.bidv_echo_server.constants.ApiRestURIConstants;
import com.example.bidv_echo_server.model.FirmInqBeneRepLayer;
import com.example.bidv_echo_server.model.FirmInqBeneReqLayer;
import com.example.bidv_echo_server.service.BidvRepService;
import com.example.bidv_echo_server.util.XmlStringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

@Controller
public class BidvEchoController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private static final String xmlHeader = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>";
    @Autowired
    BidvRepService bidvRepService;

    /**
     * 예금주조회 api 요청
     *
     * @return JSON
     */
    @RequestMapping(value = ApiRestURIConstants.INQUIRE_BENE_URI, method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<?> inquire(@RequestBody String req) {
        FirmInqBeneRepLayer rep = null;
        FirmInqBeneReqLayer firmInqBeneReqLayer = null;
        String str = XmlStringUtil.createValidXml(req);
        try{
            JAXBContext jaxbContext = JAXBContext.newInstance(FirmInqBeneReqLayer.class); // JAXB Context 생성
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller(); // Unmarshaller Object 생성
            firmInqBeneReqLayer = (FirmInqBeneReqLayer) unmarshaller.unmarshal(new StringReader(xmlHeader + str));
            System.out.println(firmInqBeneReqLayer.toString());

            rep = this.bidvRepService.replyInquireBeneficiary(firmInqBeneReqLayer);
        }catch (Exception e){
            this.logger.error("BidvEchoController error.", e);

            //시스템 에러
            rep = new FirmInqBeneRepLayer();

            rep.setStatus(500);
            rep.setBusinessErrorCode("9999");
            rep.setBusinessErrorDesc("서버에러");

            return ResponseEntity.status(rep.getStatus()).
                    header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8_VALUE).body(rep);
        }

        return ResponseEntity.status(HttpStatus.OK).
                header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8_VALUE).body(rep);
    }
}
