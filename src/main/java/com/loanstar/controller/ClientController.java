package com.loanstar.controller;

import com.loanstar.dao.ClientDao;
import com.loanstar.dao.FacilityDao;
import com.loanstar.dto.ClientFacility;
import com.loanstar.entity.Client;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ClientController {

    @Autowired
    private ClientDao clientDao;

    @Autowired
    private FacilityDao facilityManagerDao;

    @RequestMapping(value = "getClientAll")
    public String getClientAll(Integer offset, Integer limit, HttpServletRequest request, HttpServletResponse response){
        try {
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("pageNo",offset);
        map.put("pageSize",limit);

        //DTO (客户 服务机构 dto)
        List<ClientFacility> clientFacilities=new ArrayList<ClientFacility>();

        List<Client> clientList=clientDao.getClientAll(map);
        for (Client client : clientList) {
            int client_id=client.getClient_id();
            String client_name=client.getClient_name();
            String client_telphone=client.getClient_telphone();
            String client_id_number=client.getClient_id_number();
            String client_card_number=client.getClient_card_number();
            int facility_id=client.getFacility_id();

            String facility_type=facilityManagerDao.getFacility_typeByFacility_id(facility_id);

            ClientFacility clientFacility=new ClientFacility(client_id,client_name,client_telphone,client_id_number,facility_type,client_card_number);
            clientFacilities.add(clientFacility);
        }
        int total=clientDao.getClientCount();


        JSONArray jsonArray=JSONArray.fromObject(clientFacilities);
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("rows",jsonArray);
        jsonObject.put("total",total);
        try {
            PrintWriter pw=response.getWriter();
            pw.write(jsonObject.toString());
            pw.close();
            pw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "client";
    }

    @RequestMapping(value = "deleteClient")
    public String deleteClient(HttpServletRequest request, HttpServletResponse response){

        String client_id=request.getParameter("fid");

        clientDao.deleteClient(Integer.parseInt(client_id));

        return "client";
    }

    @RequestMapping(value = "updateClient")
    public String updateClient(HttpServletRequest request, HttpServletResponse response){

        String client_id=request.getParameter("client_id");
        String client_name=request.getParameter("client_name");
        String client_telphone=request.getParameter("client_telphone");
        String client_id_number=request.getParameter("client_id_number");
        String client_card_number=request.getParameter("client_card_number");

        Client client=new Client(Integer.parseInt(client_id),client_name,client_telphone,client_id_number,client_card_number);
        clientDao.updateClient(client);

        return "client";
    }
}
