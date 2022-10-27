package com.ZenPack.ZenPackTest;

import com.ZenPack.Dto.FeatureDto;
import com.ZenPack.Dto.MenuDto;
import com.ZenPack.Dto.ZenPackDto;
import com.ZenPack.ZenPackProjectApplication;
import com.ZenPack.service.Impl.ZenPackServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = ZenPackProjectApplication.class)
@AutoConfigureMockMvc
public class ZenPackControllerTest {

    @MockBean
    private ZenPackServiceImpl service;

    ObjectMapper mapper=new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    private ZenPackDto zenPackDto1;
    private ZenPackDto zenPackDto2;
    @BeforeEach
    public static void init(){
        ZenPackDto zenPackDto1 = new ZenPackDto();
        zenPackDto1.setZenPackId(1L);
        zenPackDto1.setName("Zen_Pack");
        zenPackDto1.setCreatedDate(new Date());
        zenPackDto1.setCreatedBy("Murugan");
        zenPackDto1.setUpdatedBy("Sethu");
        zenPackDto1.setUpdatedTime(new Date());
        MenuDto menuDto = new MenuDto();
        menuDto.setMenuName("Test1");
        menuDto.setParentMenuId(101);
        menuDto.setCreatedTime(new Date());
        menuDto.setCreatedBy("Mithun");

        FeatureDto featureDto = new FeatureDto();
        featureDto.setFeatureId("1");
        featureDto.setFeatureUrl("www.google.com");
        featureDto.setIcon("Feature");
        featureDto.setId(1);
        featureDto.setIsSettingMenu(true);
        featureDto.setParent(1);
        featureDto.setText("Contains Menu");

        List<FeatureDto> featureList = new ArrayList<FeatureDto>();
        featureList.add(featureDto);
        menuDto.setFeatures(featureList);

        List<MenuDto> menuList = new ArrayList<MenuDto>();
        menuList.add(menuDto);
        zenPackDto1.setMenus(menuList);

//-------------------------------------------------------------------------------------------------------//
        ZenPackDto zenPackDto2 = new ZenPackDto();
        zenPackDto2.setZenPackId(1L);
        zenPackDto2.setName("Zen_Pack");
        zenPackDto2.setCreatedDate(new Date());
        zenPackDto2.setCreatedBy("Murugan");
        zenPackDto2.setUpdatedBy("Sethu");
        zenPackDto2.setUpdatedTime(new Date());
        MenuDto menuDto1 = new MenuDto();
        menuDto1.setMenuName("Test1");
        menuDto1.setParentMenuId(101);
        menuDto1.setCreatedTime(new Date());
        menuDto1.setCreatedBy("Mithun");

        FeatureDto featureDto1 = new FeatureDto();
        featureDto1.setFeatureId("1");
        featureDto1.setFeatureUrl("www.google.com");
        featureDto1.setIcon("Feature");
        featureDto1.setId(1);
        featureDto1.setIsSettingMenu(true);
        featureDto1.setParent(1);
        featureDto1.setText("Contains Menu");

        List<FeatureDto> featureList1 = new ArrayList<FeatureDto>();
        featureList.add(featureDto1);
        menuDto.setFeatures(featureList1);

        List<MenuDto> menuList1 = new ArrayList<MenuDto>();
        menuList.add(menuDto1);

        zenPackDto1.setMenus(menuList1);
    }

    @Test
    public void should_create_new_zen_pack() throws Exception {

        ZenPackDto zenPackDto = new ZenPackDto();
        zenPackDto.setZenPackId(1L);
        zenPackDto.setName("ZenPack");
        zenPackDto.setCreatedDate(new Date());
        zenPackDto.setCreatedBy("Murugan");
        zenPackDto.setUpdatedBy("Mithun");
        zenPackDto.setUpdatedTime(new Date());
        MenuDto menuDto = new MenuDto();
        menuDto.setMenuName("Test");
        menuDto.setParentMenuId(101);
        menuDto.setCreatedTime(new Date());
        menuDto.setCreatedBy("Sethu");

        FeatureDto featureDto = new FeatureDto();
        featureDto.setFeatureId("1");
        featureDto.setFeatureUrl("www.google.com");
        featureDto.setIcon("Icon");
        featureDto.setId(1);
        featureDto.setIsSettingMenu(true);
        featureDto.setParent(1);
        featureDto.setText("Menu Contains");

        List<FeatureDto> featureList = new ArrayList<FeatureDto>();
        featureList.add(featureDto);
        menuDto.setFeatures(featureList);

        List<MenuDto> menuList = new ArrayList<MenuDto>();
        menuList.add(menuDto);

        zenPackDto.setMenus(menuList);

        String uri = "/api/v1/create";
        when(service.createZenPack(ArgumentMatchers.any(ZenPackDto.class))).thenReturn(ResponseEntity.ok(zenPackDto));
        String dto = mapper.writeValueAsString(zenPackDto);
        this.mockMvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON)
                .content(dto))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.zenPackId").value(1))
                .andExpect(jsonPath("$.name").value("ZenPack"))
                .andExpect(jsonPath("$.menus[0].menuName").value("Test"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn().getResponse().getContentAsString();
    }

    @Test
    public void should_return_all_zen_pack() throws Exception {
        List<ZenPackDto> zenPackDtoList=new ArrayList<>();
        zenPackDtoList.add(zenPackDto1);
        zenPackDtoList.add(zenPackDto2);
        String uri = "/api/v1/get_all";
        when(service.getAllZenPack()).thenReturn(zenPackDtoList);
        this.mockMvc.perform(get(uri))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", CoreMatchers.is(zenPackDtoList.size())));
    }
    @Test
    public void should_return_one_zen_pack_based_on_id() throws Exception {
        ZenPackDto zenPackDto=new ZenPackDto();
        zenPackDto.setZenPackId(1L);
        zenPackDto.setName("Zen_Pack");
        String uri = "/api/v1/getByZenPackId/{zenPackId}";
        when(service.getByZenPackId(anyLong())).thenReturn(zenPackDto);
        this.mockMvc.perform(get(uri,1L))
                .andExpect(status().isOk())
                .andExpect( jsonPath("$.zenPackId",CoreMatchers.is(1)))
                .andExpect( jsonPath("$.name",CoreMatchers.is("Zen_Pack")));
    }
    @Test
    public void delete_ze_pack_by_id() throws Exception {
        mockMvc.perform(delete("/api/v1/delete/{zenPackId}", 1L)
                        .contentType(APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andReturn();
    }
}
