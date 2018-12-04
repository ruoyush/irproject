# -*- coding: utf-8 -*-
import scrapy
import re
from pymongo import MongoClient
import unicodedata
client = MongoClient('localhost', 27017)
class JobsSpider(scrapy.Spider):
    db = client.indeed_broker
    collection = db.indeed_20171211_copy

    list_url =[]
    regex = r"((http|https):\/\/)?www.indeed.com\/rc\/(.*)"
    # for doc in collection.find():
    # # file = open(“testfile.txt”,”w”) 
    #     if re.search(regex, doc['url']):
    #         pass
    #     else:
    #         list_url.append(doc['url'])

    for x in range(0,15815):
        doc = collection.find_one({"docid": str(x)})
        if re.search(regex, doc['url']):
            pass
        else:
            list_url.append(doc['url'])

    name = 'jobs'
    allowed_domains = ['www.indeed.com']

    start_urls = [url.strip() for url in list_url]
    


    def parse(self, response):
        jobtitle = response.xpath('//*[@class="jobtitle"]/font/text()').extract_first()
        company =response.xpath('//*[@class="company"]/text()').extract_first()
        job_summary = response.xpath('//*[@id="job_summary"]').extract()
        location = response.xpath('//*[@class="location"]/text()').extract_first()
        canonical = response.xpath('//link[@rel="canonical"]/@href').extract_first()
        url = "https://www.indeed.com"+canonical

        if jobtitle is None or company is None or job_summary is None or location is None or canonical is None:
            pass
        else:
            str = ''.join(job_summary)
            p = re.compile(r'<.*?>')
            job_nohtml = p.sub(' ',str)
            job_nounicode = unicodedata.normalize('NFKD', "".join(job_nohtml)).encode('ascii','ignore').decode("utf-8") 

            yield {'Job Title': jobtitle, 'Company': company, 'Location': location, 'Summary': job_nounicode, 'url': url} 

 