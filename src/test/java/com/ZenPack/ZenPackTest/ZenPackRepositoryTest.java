package com.ZenPack.ZenPackTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ZenPack.Dto.FeatureDto;
import com.ZenPack.Dto.MenuDto;
import com.ZenPack.model.ZenPack;
import com.ZenPack.repository.ZenPackRepository;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ZenPackRepositoryTest {

    @Autowired
    public ZenPackRepository repositroy;

    @Test
    public void saveZenPackTest() {

        ZenPack zenpack = new ZenPack();
        zenpack.setZenPackId(101L);
        zenpack.setName("test zenpack1");
        zenpack.setCreatedBy("team1");
        zenpack.setCreatedDate(new Date());
        zenpack.setUpdatedBy("Team1");
        zenpack.setUpdatedTime(new Date());

        MenuDto menuDto = new MenuDto();
        menuDto.setMenuName("Test_zenpack1_menu");
        menuDto.setParentMenuId(101);
        menuDto.setCreatedTime(new Date());
        menuDto.setCreatedBy("Team2");

        FeatureDto featureDto = new FeatureDto();
        featureDto.setFeatureId("202");
        featureDto.setFeatureUrl("http://localhost:8091/api/v1/create");
        featureDto.setIcon("feature1");
        featureDto.setId(201);
        featureDto.setIsSettingMenu(true);
        featureDto.setParent(101);
        featureDto.setText("Menu Feature");

        List<FeatureDto> featureList = new ArrayList<FeatureDto>();
        featureList.add(featureDto);
        menuDto.setFeatures(featureList);

        List<MenuDto> menuList = new ArrayList<MenuDto>();
        menuList.add(menuDto);

        zenpack.setMenus(menuList);

        repositroy.save(zenpack);

        assertEquals(zenpack,zenpack);
        assertThat(zenpack).isNotNull();

        System.out.println(zenpack.toString());

    }

}