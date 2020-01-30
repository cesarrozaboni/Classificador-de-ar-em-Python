using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Text;
using System.Web;
using System.Web.Mvc;
using WebApp.ViewModel;

namespace WebApp.Controllers
{
    public class HomeController : Controller
    {
        public ActionResult Index()
        {
            return View();
        }
        
        [HttpGet]
        public JsonResult DadosProduto(Produto produto)
        {
            int valor;

            if(!int.TryParse(produto.Valor, out valor))
            {
                return Json("Valor do produto esta incorreto", JsonRequestBehavior.AllowGet);
            }

            if (!int.TryParse(produto.ValorEntrada, out valor))
            {
                return Json("Valor de entrada incorreto", JsonRequestBehavior.AllowGet);
            }

            if (!int.TryParse(produto.QtdParcelas, out valor))
            {
                return Json("Quantidade de parcelas esta incorreto", JsonRequestBehavior.AllowGet);
            }

            var lClt = new WebClient();

            string lURL = "http://api.bcb.gov.br/dados/serie/bcdata.sgs.11/dados";
            
            byte[] lDataBuffer = lClt.DownloadData(lURL);

            string lOut = Encoding.ASCII.GetString(lDataBuffer);

            return Json("", JsonRequestBehavior.AllowGet);
        }
    }
}