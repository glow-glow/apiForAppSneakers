package com.example.apiForAppSneakers.parsing;

import com.example.apiForAppSneakers.entity.Shop;
import com.example.apiForAppSneakers.entity.Sneakers;
import com.example.apiForAppSneakers.service.SneakersService;
import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class ParseOne extends IOException {
    private final SneakersService sneakersService;

    @Scheduled(fixedDelay = 345600000)
    public void pars() {
        Document page;


        try {
            page = Jsoup.connect("https://www.adidas.ru/muzhchiny-obuv-outlet").
                    timeout(10 * 1000)
                    .userAgent("Mozilla")
                    .referrer("http://www.google.com")
                    .get();

            Elements tableDetails = page.select("div[class=grid-item___3rAkS]");
            Elements tableSneakers = tableDetails.select("a");
            int i = 0;
            //добавить пол и размер


                for (Element tableSn : tableSneakers) {
                    if (i < 47) {


                        String sneakersName = tableSn.select("div[class=gl-product-card__details]").text();
                        Elements sneakersURl = tableSn.select("img");
                        String url = tableSn.attr("href");

                        try {

                            String img = sneakersURl.first().attr("src");
                            Document pageForPrice = Jsoup.connect("https://www.adidas.ru/" + url).userAgent("Google").referrer("http://www.google.com").get();
                            Elements OldAndNewPrice = pageForPrice.select("div[class=gl-price gl-price--horizontal notranslate]");
                            String oldPrice = OldAndNewPrice.select("div[class=gl-price-item gl-price-item--crossed notranslate]").text();
                            String newPrice = OldAndNewPrice.select("div[class=gl-price-item gl-price-item--sale notranslate]").text();
                            if(oldPrice.length() != 0 || newPrice.length() != 0) {
                               // String shopName = "adidas";
                               // Shop shop = new Shop();
                                //shop.setNameShop(shopName);
                                Sneakers sneakers = new Sneakers();
                                sneakers.setNameSneakers(sneakersName);
                                sneakers.setUrlSneakers("https://www.adidas.ru/" + url);
                                sneakers.setImgUrl(img);
                                sneakers.setOldPriceSneakers(oldPrice);
                                sneakers.setNewPriceSneakers(newPrice);
                                //sneakers.setShop(shop);
                                sneakersService.save(sneakers);
                            }
                            i++;


                        } catch (Exception e) {

                        }

                    }else {
                        break;
                    }
                }



        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }


}
