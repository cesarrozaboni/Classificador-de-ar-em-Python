using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace WebApp.ViewModel
{
    [Serializable]
    public class Produto
    {
        public string Codigo { get; set; }
        public string Nome { get; set; }
        public string Valor { get; set; }
        public string ValorEntrada { get; set; }
        public string QtdParcelas { get; set; }
    }


}