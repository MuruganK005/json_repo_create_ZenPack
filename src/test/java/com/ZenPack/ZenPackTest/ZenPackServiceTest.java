package com.ZenPack.ZenPackTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import com.ZenPack.ZenPackProjectApplication;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.ZenPack.Dto.FeatureDto;
import com.ZenPack.Dto.MenuDto;
import com.ZenPack.model.ZenPack;
import com.ZenPack.repository.ZenPackRepository;
import com.ZenPack.service.Services.ZenPackService;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ZenPackProjectApplication.class)
public class ZenPackServiceTest {

    @Autowired
    private ZenPackService zenPackService;

    @MockBean
    private ZenPackRepository repository;

    private ZenPack zenPack;
    private ZenPack zenPack2;

    @BeforeEach
    public static void init(){
        ZenPack zenPack = new ZenPack();
        zenPack.setZenPackId(1L);
        zenPack.setName("Zen_Pack");
        zenPack.setCreatedDate(new Date());
        zenPack.setCreatedBy("Murugan");
        zenPack.setUpdatedBy("Sethu");
        zenPack.setUpdatedTime(new Date());
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
        zenPack.setMenus(menuList);

//-------------------------------------------------------------------------------------------------------//
        ZenPack zenPack2 = new ZenPack();
        zenPack2.setZenPackId(1L);
        zenPack2.setName("Zen_Pack");
        zenPack2.setCreatedDate(new Date());
        zenPack2.setCreatedBy("Murugan");
        zenPack2.setUpdatedBy("Sethu");
        zenPack2.setUpdatedTime(new Date());
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

        zenPack2.setMenus(menuList1);
    }

    @Test
    public void create_ze_pack_service_test() {

        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setAmbiguityIgnored(true);
        ZenPack zenPack;
        zenPack = ZenPack.builder()
                .zenPackId(1L)
                .name("ZenPack")
                .createdDate(new Date())
                .createdBy("XXXX")
                .updatedBy("YYYY")
                .updatedTime(new Date())
                .build();
        given(repository.findByZenPackId(zenPack.getZenPackId()))
                .willReturn(Optional.empty());
        given(repository.save(zenPack)).willReturn(ZenPack.builder().build());
        System.out.println(repository);
        System.out.println(zenPackService);
        ZenPack savedList = zenPackService.saveZenPack(zenPack).getBody();
        System.out.println(savedList);
        assertThat(savedList).isNotNull();

    }
    @Test
    public void get_zen_pack_by_id_service() {
        ZenPack zenPack = new ZenPack();
        zenPack.setZenPackId(1L);
        zenPack.setName("Zen_Pack");
        zenPack.setCreatedDate(new Date());
        zenPack.setCreatedBy("Murugan");
        zenPack.setUpdatedBy("Sethu");
        zenPack.setUpdatedTime(new Date());
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
        zenPack.setMenus(menuList);
        ZenPack zenPack1;
        zenPack1 = ZenPack.builder()
                .zenPackId(1L)
                .name("ZenPack")
                .createdDate(new Date())
                .createdBy("XXXX")
                .updatedBy("YYYY")
                .updatedTime(new Date())
                .build();

        Mockito.when(repository.findByZenPackId(anyLong())).thenReturn(Optional.of(zenPack1));
    }
    @Test
    public void get_all_zen_pack() throws JsonProcessingException {
        ZenPack zenPack = new ZenPack();
        zenPack.setZenPackId(1L);
        zenPack.setName("Zen_Pack");
        zenPack.setCreatedDate(new Date());
        zenPack.setCreatedBy("Murugan");
        zenPack.setUpdatedBy("Sethu");
        zenPack.setUpdatedTime(new Date());
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
        zenPack.setMenus(menuList);

//-------------------------------------------------------------------------------------------------------//
        ZenPack zenPack2 = new ZenPack();
        zenPack2.setZenPackId(1L);
        zenPack2.setName("Zen_Pack");
        zenPack2.setCreatedDate(new Date());
        zenPack2.setCreatedBy("Murugan");
        zenPack2.setUpdatedBy("Sethu");
        zenPack2.setUpdatedTime(new Date());
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
        zenPack2.setMenus(menuList1);

        List<ZenPack> zenPacks = new ArrayList<>();
        zenPacks.add(zenPack);
        zenPacks.add(zenPack2);

        Mockito.when(repository.findAll()).thenReturn(zenPacks);

       // assertThat(zenPackService.getAllZenPack()).isEqualTo(zenPacks);
    }
    /*@Test
    public void delete_zen_pack_by_id_service() {
        ZenPack zenPack = new ZenPack();
        zenPack.setZenPackId(1L);
        zenPack.setName("Zen_Pack");
        zenPack.setCreatedDate(new Date());
        zenPack.setCreatedBy("Murugan");
        zenPack.setUpdatedBy("Sethu");
        zenPack.setUpdatedTime(new Date());
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
        zenPack.setMenus(menuList);
        ZenPack zenPack1;
        zenPack1 = ZenPack.builder()
                .zenPackId(1L)
                .name("ZenPack")
                .createdDate(new Date())
                .createdBy("XXXX")
                .updatedBy("YYYY")
                .updatedTime(new Date())
                .build();

    }
*/
}
