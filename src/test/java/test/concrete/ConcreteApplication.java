//package test.concrete;
//
//import org.junit.runner.RunWith;
//import org.mockito.junit.MockitoJUnitRunner;
//import org.springframework.boot.test.context.SpringBootTest;

//package com.accenture.concrete.controller;
//
//import org.junit.Before;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.MockitoJUnitRunner;
//
//import com.accenture.concrete.client.IClienteCategorias;
//import com.accenture.concrete.client.IClienteCupones;
//import com.accenture.concrete.service.impl.ConcreteServiceImpl;
//
//@SpringBootTest
//@RunWith(MockitoJUnitRunner.class)
//class ConcreteApplication {
//
//}
//
//	@InjectMocks
//	ConcreteServiceImpl concreteServiceImpl;
//
//	@Mock
//	IClienteCupones iClienteCuponesMock;
//
//	@Mock
//	IClienteCategorias iClienteCategoriasMock;
//
//	String responseCoupons = new String();
//
//	String responseCategory = new String();
//
//	@Before
//	public void cargaBody() {
//
//		responseCoupons = "[\n" + "  {\n" + "    \"id\": \"COUPON_1\",\n" + "    \"description\": \"50% Discount\",\n"
//				+ "    \"seller\": \"Crazy Seller\",\n"
//				+ "    \"image\": \"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\",\n"
//				+ "    \"expiresAt\": \"2045-12-01\"\n" + "  },\n" + "  {\n" + "    \"id\": \"COUPON_2\",\n"
//				+ "    \"description\": \"5% Discount\",\n" + "    \"seller\": \"The Seller\",\n"
//				+ "    \"image\": \"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\",\n"
//				+ "    \"expiresAt\": \"2042-12-25\"\n" + "  },\n" + "  {\n" + "    \"id\": \"COUPON_3\",\n"
//				+ "    \"description\": \"100% Discount\",\n" + "    \"seller\": \"Old Seller\",\n"
//				+ "    \"image\": \"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\",\n"
//				+ "    \"expiresAt\": \"2018-10-01\"\n" + "  },\n" + "  {\n" + "    \"id\": \"COUPON_4\",\n"
//				+ "    \"description\": \"1% Discount\",\n" + "    \"seller\": \"Mega Discount\",\n"
//				+ "    \"image\": \"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\",\n"
//				+ "    \"expiresAt\": \"2055-10-01\"\n" + "  },\n" + "  {\n" + "    \"id\": \"COUPON_5\",\n"
//				+ "    \"description\": \"100% Discount\",\n" + "    \"seller\": \"The Discount\",\n"
//				+ "    \"image\": \"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\",\n"
//				+ "    \"expiresAt\": \"2016-11-01\"\n" + "  }\n" + "]";
//
//		responseCategory = "{\n" + "  \"id\": \"ROOT\",\n" + "  \"name\": \"LEGACY_NAVIGATION\",\n"
//				+ "  \"subcategories\": [\n" + "    {\n" + "      \"id\": \"MOB\",\n"
//				+ "      \"name\": \"MOBILE_MARKET\",\n" + "      \"subcategories\": [\n" + "        {\n"
//				+ "          \"id\": \"video-games\",\n" + "          \"name\": \"Video Games\",\n"
//				+ "          \"relevance\": 150,\n" + "          \"subcategories\": [\n" + "            {\n"
//				+ "              \"id\": \"nintendo\",\n" + "              \"name\": \"Nintendo\",\n"
//				+ "              \"subcategories\": [\n" + "                {\n"
//				+ "                  \"id\": \"switch\",\n" + "                  \"name\": \"Switch\",\n"
//				+ "                  \"relevance\": 422\n" + "                }\n" + "              ],\n"
//				+ "              \"largeImageUrl\": \"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\",\n"
//				+ "              \"mediumImageUrl\": \"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\",\n"
//				+ "              \"smallImageUrl\": \"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\"\n"
//				+ "            }\n" + "          ],\n"
//				+ "          \"iconImageUrl\": \"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\"\n"
//				+ "        },\n" + "        {\n" + "          \"id\": \"sports\",\n"
//				+ "          \"name\": \"Sports\",\n" + "          \"relevance\": 1,\n"
//				+ "          \"subcategories\": [\n" + "            {\n" + "              \"id\": \"bike\",\n"
//				+ "              \"name\": \"Bike\",\n" + "              \"relevance\": 350,\n"
//				+ "              \"subcategories\": [],\n"
//				+ "              \"largeImageUrl\": \"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\",\n"
//				+ "              \"mediumImageUrl\": \"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\",\n"
//				+ "              \"smallImageUrl\": \"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\"\n"
//				+ "            }\n" + "          ],\n"
//				+ "          \"iconImageUrl\": \"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\"\n"
//				+ "        },\n" + "        {\n" + "          \"id\": \"electronics\",\n"
//				+ "          \"name\": \"Electronics\",\n" + "          \"subcategories\": [\n" + "            {\n"
//				+ "              \"id\": \"tv\",\n" + "              \"name\": \"TV\",\n"
//				+ "              \"subcategories\": [\n" + "                {\n" + "                  \"id\": \"4k\",\n"
//				+ "                  \"name\": \"4K\",\n" + "                  \"relevance\": 700\n"
//				+ "                }\n" + "              ],\n"
//				+ "              \"largeImageUrl\": \"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\",\n"
//				+ "              \"mediumImageUrl\": \"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\",\n"
//				+ "              \"smallImageUrl\": \"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\"\n"
//				+ "            }\n" + "          ],\n"
//				+ "          \"iconImageUrl\": \"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\"\n"
//				+ "        },\n" + "        {\n" + "          \"id\": \"outdoor\",\n"
//				+ "          \"name\": \"Outdoor\",\n" + "          \"relevance\": 3,\n"
//				+ "          \"subcategories\": [],\n"
//				+ "          \"iconImageUrl\": \"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\"\n"
//				+ "        },\n" + "        {\n" + "          \"id\": \"food\",\n" + "          \"name\": \"Food\",\n"
//				+ "          \"relevance\": 4,\n" + "          \"subcategories\": [\n" + "            {\n"
//				+ "              \"id\": \"hamburger\",\n" + "              \"name\": \"Hamburger\",\n"
//				+ "              \"relevance\": 350,\n" + "              \"subcategories\": [],\n"
//				+ "              \"largeImageUrl\": \"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\",\n"
//				+ "              \"mediumImageUrl\": \"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\",\n"
//				+ "              \"smallImageUrl\": \"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\"\n"
//				+ "            }\n" + "          ],\n"
//				+ "          \"iconImageUrl\": \"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\"\n"
//				+ "        },\n" + "        {\n" + "          \"id\": \"books\",\n" + "          \"name\": \"Books\",\n"
//				+ "          \"relevance\": 2,\n" + "          \"subcategories\": [],\n"
//				+ "          \"iconImageUrl\": \"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\"\n"
//				+ "        },\n" + "        {\n" + "          \"id\": \"travel\",\n"
//				+ "          \"name\": \"Travel\",\n" + "          \"relevance\": 5,\n"
//				+ "          \"subcategories\": [],\n"
//				+ "          \"iconImageUrl\": \"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\"\n"
//				+ "        },\n" + "        {\n" + "          \"id\": \"health\",\n"
//				+ "          \"name\": \"Health\",\n" + "          \"relevance\": 6,\n"
//				+ "          \"subcategories\": [],\n"
//				+ "          \"iconImageUrl\": \"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\"\n"
//				+ "        },\n" + "        {\n" + "          \"id\": \"toys\",\n" + "          \"name\": \"Toys\",\n"
//				+ "          \"relevance\": 99,\n" + "          \"subcategories\": [\n" + "            {\n"
//				+ "              \"id\": \"puzzles\",\n" + "              \"name\": \"Puzzles\",\n"
//				+ "              \"relevance\": 100,\n" + "              \"subcategories\": [],\n"
//				+ "              \"largeImageUrl\": \"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\",\n"
//				+ "              \"mediumImageUrl\": \"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\",\n"
//				+ "              \"smallImageUrl\": \"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\"\n"
//				+ "            }\n" + "          ],\n"
//				+ "          \"iconImageUrl\": \"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\"\n"
//				+ "        }\n" + "      ]\n" + "    }\n" + "  ]\n" + "}";
//
//	}
//
//	@Test
//	void contextLoads() {
//
//	}
//
//}
